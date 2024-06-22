package ScreeningHumanity.MemberMypageServer.bookmark.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkOutVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IsBookmark {

        private Boolean isBookmark;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class registeredBookmark {

        private String stockName;
        private String stockCode;
        private Long price;
        private String prdyCtrt; //등락률
    }
}
