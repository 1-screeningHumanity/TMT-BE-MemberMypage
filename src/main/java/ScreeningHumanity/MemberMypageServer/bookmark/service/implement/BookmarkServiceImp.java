package ScreeningHumanity.MemberMypageServer.bookmark.service.implement;

import ScreeningHumanity.MemberMypageServer.bookmark.dto.BookmarkDto;
import ScreeningHumanity.MemberMypageServer.bookmark.entity.BookmarkEntity;
import ScreeningHumanity.MemberMypageServer.bookmark.repository.BookmarkJpaRepository;
import ScreeningHumanity.MemberMypageServer.bookmark.service.BookmarkService;
import ScreeningHumanity.MemberMypageServer.global.common.exception.CustomException;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImp implements BookmarkService {

    private final BookmarkJpaRepository bookmarkJpaRepository;

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
}
