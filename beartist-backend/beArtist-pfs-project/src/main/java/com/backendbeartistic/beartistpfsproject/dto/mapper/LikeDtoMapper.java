package com.backendbeartistic.beartistpfsproject.dto.mapper;

import com.backendbeartistic.beartistpfsproject.dto.LikeDto;
import com.backendbeartistic.beartistpfsproject.dto.TwitDto;
import com.backendbeartistic.beartistpfsproject.dto.UserDto;
import com.backendbeartistic.beartistpfsproject.entities.Like;
import com.backendbeartistic.beartistpfsproject.entities.User;

import java.util.ArrayList;
import java.util.List;

public class LikeDtoMapper {

    public static LikeDto toLikeDto(Like like, User reqUser){
        UserDto user=UserDtoMapper.toUserDto(like.getUser());
        UserDto reqUserDto=UserDtoMapper.toUserDto(reqUser);
        TwitDto twit=TwitDtoMapper.toTwitDto(like.getTwit(),reqUser);


        LikeDto likeDto=new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setTwit(twit);
        likeDto.setUser(user);
         return likeDto;
    }

    public static List<LikeDto> toLikeDtos(List<Like> likes, User reqUser){
       List<LikeDto> likeDtos=new ArrayList<>();

       for(Like like:likes){
           UserDto user=UserDtoMapper.toUserDto(like.getUser());
           TwitDto twit=TwitDtoMapper.toTwitDto(like.getTwit(),reqUser);

           LikeDto likeDto=new LikeDto();
           likeDto.setId(like.getId());
           likeDto.setTwit(twit);
           likeDto.setUser(user);
           likeDtos.add(likeDto);
       }
       return likeDtos;
    }
}
