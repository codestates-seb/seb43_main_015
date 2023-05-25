package com.mainproject.domain.member.mapper;

import com.mainproject.domain.member.dto.MemberPatchDto;
import com.mainproject.domain.member.dto.MemberPostDto;
import com.mainproject.domain.member.dto.MemberResponseDto;
import com.mainproject.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto requestBody);

    Member memberPatchDtoToMember(MemberPatchDto requestBody);

    @Mapping(source = "createdAt", target = "memberCreatedAt")
    @Mapping(source = "modifiedAt", target = "memberModifiedAt")
    MemberResponseDto memberToMemberResponseDto(Member member);

}