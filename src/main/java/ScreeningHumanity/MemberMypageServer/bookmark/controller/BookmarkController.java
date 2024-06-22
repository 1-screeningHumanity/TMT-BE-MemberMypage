package ScreeningHumanity.MemberMypageServer.bookmark.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import ScreeningHumanity.MemberMypageServer.bookmark.dto.BookmarkDto;
import ScreeningHumanity.MemberMypageServer.bookmark.service.BookmarkService;
import ScreeningHumanity.MemberMypageServer.bookmark.vo.in.BookmarkInVo;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import ScreeningHumanity.MemberMypageServer.global.common.token.DecodingToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Bookmark API", description = "회원 종목 즐겨찾기 관련 API")
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final ModelMapper modelMapper;
    private final DecodingToken decodingToken;

    @Operation(summary = "회원 종목 즐겨찾기 등록 api", description = "회원의 즐겨찾기 목록에 종목을 추가합니다.")
    @PostMapping("/bookmark")
    private BaseResponse<Void> bookmarkStock(
            @RequestHeader(AUTHORIZATION) String accessToken,
            @RequestBody BookmarkInVo.Create requestVo
    ){
        String uuid = decodingToken.getUuid(accessToken);
        bookmarkService.createNewBookmark(
                uuid,
                modelMapper.map(requestVo, BookmarkDto.Create.class)
        );

        return new BaseResponse<>();
    }
}
