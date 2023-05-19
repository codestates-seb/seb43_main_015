package com.mainproject.domain.member.controller;

import com.mainproject.domain.member.dto.MemberPatchDto;
import com.mainproject.domain.member.dto.MemberPostDto;
import com.mainproject.domain.member.entity.Member;
import com.mainproject.domain.member.mapper.MemberMapper;
import com.mainproject.domain.member.service.MemberService;
import com.mainproject.global.response.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto requestBody) {
        Member member = mapper.memberPostDtoToMember(requestBody);
        Member createMember = memberService.createMember(member);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(createMember)), HttpStatus.CREATED
        );
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody LoginDto loginDto) {
//        String email = loginDto.getEmail();
//        String password = loginDto.getPassword();
//
//        if (loginDto.getPassword().equals("password")) {
//            return ResponseEntity.ok(TokenDto.builder()
//                    .accessToken("secret")
//                    .build());
//        }
//        return ResponseEntity.badRequest().build();
//
//    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@Valid @RequestBody MemberPatchDto requestBody,
                                      @PathVariable("member-id") Long memberId) {
        requestBody.setMemberId(memberId);
        Member member = mapper.memberPatchDtoToMember(requestBody);
        Member updateMember = memberService.updateMember(member);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(updateMember)), HttpStatus.OK
        );
    }

    @GetMapping("/{member-id}")
    public ResponseEntity findMember(@PathVariable("member-id") Long memberId) {
        Member member = memberService.findMember(memberId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") Long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
