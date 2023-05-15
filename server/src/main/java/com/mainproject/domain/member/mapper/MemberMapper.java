package com.mainproject.domain.member.mapper;

import com.mainproject.domain.member.dto.MemberDto;
import com.mainproject.domain.member.dto.MemberPostDto;
import com.mainproject.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberDto.Post requestBody);
    Member memberPostDtoToMember(MemberPostDto requestBody);

    Member memberPatchDtoToMember(MemberDto.Patch requestBody);

    @Mapping(source = "createdAt", target = "memberCreatedAt")
    @Mapping(source = "modifiedAt", target = "memberModifiedAt")
    MemberDto.Response memberToMemberResponseDto(Member member);

}