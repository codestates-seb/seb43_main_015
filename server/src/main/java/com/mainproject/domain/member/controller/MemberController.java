package com.mainproject.domain.member.controller;

import com.mainproject.domain.member.dto.MemberDto;
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
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = mapper.memberPostDtoToMember(requestBody);
        Member createMember = memberService.createMember(member);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(createMember)), HttpStatus.CREATED
        );
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@Valid @RequestBody MemberDto.Patch requestBody,
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
