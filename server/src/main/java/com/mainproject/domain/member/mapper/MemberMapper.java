package com.mainproject.domain.member.mapper;

import com.mainproject.domain.member.dto.MemberDto;
import com.mainproject.domain.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    default Member memberPostDtoToMember(MemberDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        return Member.builder()
                .email(requestBody.getEmail())
                .username(requestBody.getUsername())
                .password(requestBody.getPassword())
                .build();
    }

    default Member memberPatchDtoToMember(MemberDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        }

        return Member.builder()
                .memberId(requestBody.getMemberId())
                .password(requestBody.getPassword())
                .username(requestBody.getUsername())
                .build();
    }

    default MemberDto.Response memberToMemberResponseDto(Member member) {
        if (member == null) {
            return null;
        }
        return MemberDto.Response.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .password(member.getPassword())
                .username(member.getUsername())
                .memberCreatedAt(member.getCreateAt())
                .build();
    }
}
