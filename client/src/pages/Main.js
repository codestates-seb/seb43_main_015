import React, { useState, useEffect } from 'react';
import axios from 'axios';

import GameModal from './GameModal';

import {
  MainContainer,
  GameDirectory,
  GameListContainer,
  GameList,
  GameItem,
} from '../style/MainStyle';

function Main() {
  const [gameList, setGameList] = useState([]);
  const [selectedGame, setSelectedGame] = useState(null);
  const [GameModalOn, setGameModalOn] = useState(false);
  const [comment, setComment] = useState('');

  useEffect(() => {
    axios.get('http://localhost:3001/data')
      .then(response => {
        setGameList(response.data);
      })
      .catch(error => {
        console.error('Error', error);
      });
  }, []);

  // GameItem 에서 게임을 클릭했을 때 실행되는 함수
  const handleGameItemClick = (game) => {
    // 선택된 game -> selectedGame 상태 변수에 저장
    setSelectedGame(game);
    // GameModalOn 상태 변수를 기본값 false -> true 로 변경
    setGameModalOn(true);
    // setComment('');
  };

  // 댓글 입력 값이 변경될 때 실행되는 함수
  const handleCommentChange = (event) => {
    // 입력된 값을 가져와서 comment 상태 변수에 저장
    setComment(event.target.value);
  };

  const handleCommentSubmit = () => {
    // 공백으로 제출시 제출 되는걸 방지하기 위해 thim 메서드를 이용 
    if (comment.trim() === '') {
      return; 
    }
  
    //시간
    const today = new Date();

    // 새로운 댓글 객체 생성
    const newComment = {
      text: comment,
      date: today.toLocaleString(),
    };
  
    // 선택된 게임의 comments 배열에 새로운 댓글 추가 , 스프레드문법(...)을 사용하여 기존 배열을 복사하고 newComment 배열을 추가!
    const updatedComments = [...selectedGame.comments, newComment];
  
    // 선택된 게임 객체를 업데이트하고 업데이트된 객체를 gameList에 반영
    const updatedGame = {
      ...selectedGame,
      // 업데이트된 댓글 배열을 선택된 게임 객체의 comments 속성에 할당
      comments: updatedComments,
    };

    // 모든 배열의 아이템에 function을 실행하는 Method === map
    const updatedGameList = gameList.map(game =>
      // game.id 와 selectedGame.id 가 같으면 updatedGame 을 반환 , 아니면 기본 game 반환 
      // 해당한 곳 에 댓글을 넣고 그 해당한 곳에만 그 댓글이 보이게 하기 위해 작성
      game.id === selectedGame.id ? updatedGame : game
    );
  
    // PUT 요청을 보내어 db.json의 해당 게임 업데이트
    axios
    .put(`http://localhost:3001/data/${selectedGame.id}`, updatedGame)
    .then(response => {
      console.log('댓글이 성공적으로 추가되었습니다.', response.data);
      // 선택된 게임의 댓글이 추가되었을 때, 해당 게임 객체의 상태를 업데이트하여 화면에 출력 , 즉 실시간으로 댓글이 추가된 게임의 정보를 확인할 수 있다.
      setSelectedGame(updatedGame); 
      // 화면을 업데이트하고 selectedGame을 초기화
      setGameList(updatedGameList);
      setComment(''); // 추가: 댓글 초기화
    })
    .catch(error => {
      console.error('댓글 추가 중 에러가 발생하였습니다.', error);
    });
  };
  
  return (
    <>
      <GameModal
        show={GameModalOn}
        onHide={() => setGameModalOn(false)}
        game={selectedGame}
        comment={comment}
        onCommentChange={handleCommentChange}
        onCommentSubmit={handleCommentSubmit}
      />
      
      <MainContainer>
        <GameDirectory>게임 목록</GameDirectory>
        <GameListContainer>
          <GameList>
            {gameList.map((game) => (
              <GameItem key={game.id} onClick={() => handleGameItemClick(game)}>
                <img src={game.imageUrl} alt='게임 이미지' />
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
    </>
  );
}

export default Main;
