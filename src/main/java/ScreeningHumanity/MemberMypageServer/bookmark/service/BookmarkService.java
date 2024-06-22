package ScreeningHumanity.MemberMypageServer.bookmark.service;

import ScreeningHumanity.MemberMypageServer.bookmark.dto.BookmarkDto;
import ScreeningHumanity.MemberMypageServer.bookmark.vo.out.BookmarkOutVo;
import java.util.List;

public interface BookmarkService {
    void createNewBookmark(String uuid, BookmarkDto.Create requestDto);

    void deleteBookmark(String uuid, String stockCode);

    BookmarkOutVo.IsBookmark isBookmarkStock(String uuid, String stockCode);
//
//    List<BookmarkOutVo.registeredBookmark> searchRegisteredBookmark();
}
