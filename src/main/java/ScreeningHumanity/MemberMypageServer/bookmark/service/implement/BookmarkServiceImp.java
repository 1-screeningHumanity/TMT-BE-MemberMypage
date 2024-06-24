package ScreeningHumanity.MemberMypageServer.bookmark.service.implement;

import ScreeningHumanity.MemberMypageServer.bookmark.dto.BookmarkDto;
import ScreeningHumanity.MemberMypageServer.bookmark.entity.BookmarkEntity;
import ScreeningHumanity.MemberMypageServer.bookmark.entity.MinOfStockEntity;
import ScreeningHumanity.MemberMypageServer.bookmark.repository.BookmarkJpaRepository;
import ScreeningHumanity.MemberMypageServer.bookmark.repository.MinOfStockJpaRepository;
import ScreeningHumanity.MemberMypageServer.bookmark.service.BookmarkService;
import ScreeningHumanity.MemberMypageServer.bookmark.vo.out.BookmarkOutVo;
import ScreeningHumanity.MemberMypageServer.global.common.exception.CustomException;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImp implements BookmarkService {

    private final BookmarkJpaRepository bookmarkJpaRepository;
    private final MinOfStockJpaRepository minOfStockJpaRepository;

    @Transactional
    @Override
    public void createNewBookmark(String uuid, BookmarkDto.Create requestDto) {

        if (Boolean.TRUE == bookmarkJpaRepository.existsByUuidAndStockCode(uuid,
                requestDto.getStockCode())) {
            throw new CustomException(BaseResponseCode.ALREADY_EXIST_BOOKMARK_STOCK_ERROR);
        }

        bookmarkJpaRepository.save(BookmarkEntity
                .builder()
                .uuid(uuid)
                .stockCode(requestDto.getStockCode())
                .stockName(requestDto.getStockName())
                .build());
    }

    @Transactional
    @Override
    public void deleteBookmark(String uuid, String stockCode) {

        BookmarkEntity findData = bookmarkJpaRepository.findByUuidAndStockCode(uuid,
                stockCode).orElseThrow(
                () -> new CustomException(BaseResponseCode.NOT_EXIST_BOOKMARK_STOCK_ERROR));

        bookmarkJpaRepository.delete(findData);
    }

    @Transactional(readOnly = true)
    @Override
    public BookmarkOutVo.IsBookmark isBookmarkStock(String uuid, String stockCode) {

        Boolean isExist = bookmarkJpaRepository.existsByUuidAndStockCode(uuid, stockCode);
        return BookmarkOutVo.IsBookmark
                .builder()
                .isBookmark(isExist)
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookmarkOutVo.registeredBookmark> searchRegisteredBookmark(String uuid) {

        List<BookmarkEntity> findData = bookmarkJpaRepository.findByUuid(uuid);

        List<String> stockCodes = findData.stream().map(
                BookmarkEntity::getStockCode
        ).collect(Collectors.toList());

        List<MinOfStockEntity> findStockData = minOfStockJpaRepository.findByStockCodeIn(
                stockCodes);

        Map<String, MinOfStockEntity> stockDataMap = findStockData.stream()
                .collect(Collectors.toMap(MinOfStockEntity::getStockCode, stock -> stock));

        AtomicLong atomicLong = new AtomicLong(1L);

        return findData.stream()
                .map(bookmark -> {
                    MinOfStockEntity stockData = stockDataMap.get(bookmark.getStockCode());
                    return BookmarkOutVo.registeredBookmark.builder()
                            .indexId(atomicLong.getAndIncrement())
                            .stockName(stockData != null ? stockData.getHts_kor_isnm() : null)
                            .stockCode(stockData != null ? stockData.getStockCode() : null)
                            .price(stockData != null ? Long.parseLong(stockData.getStck_prpr()) : null)
                            .prdyCtrt(stockData != null ? stockData.getPrdy_ctrt() : null)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
