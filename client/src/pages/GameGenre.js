import React, { useState, useEffect } from 'react';
import axios from 'axios';

import {
  MainContainer,
  GameDirectory,
  GameListContainer,
  GameList,
  GameItem,
} from '../style/MainStyle';

const GameGenre = ({ genre }) => {
  const [gameList, setGameList] = useState([]);
  const genreGames = gameList.filter(game => game.genre === genre);

  useEffect(() => {
    axios
      .get('http://localhost:3001/data')
      .then(response => {
        setGameList(response.data);
      })
      .catch(error => {
        console.error('Error', error);
      });
  }, []);

  return (
    <MainContainer>
      <GameDirectory>{genre}</GameDirectory>
      <GameListContainer>
        <GameList>
          {genreGames.map((game) => (
            <GameItem key={game.id}>
              <img src={game.imageUrl} alt='게임 이미지'/>
              <p>게임 제목: {game.title}</p>
              <p>플랫폼: {game.platform}</p>
              <p>장르: {game.genre}</p>
              <p>제작사: {game.producer}</p>
              <p>제공사: {game.provider}</p>
              <p>등급: {game.level}</p>
              <p>출시일: {game.year}</p>
            </GameItem>
          ))}
        </GameList>
      </GameListContainer>
    </MainContainer>
  );
}

export default GameGenre;