import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import gamedata from '../gamedata.json';

const MainContainer = styled.div`

/* background-color: blue; */
`;

const GameDirectory = styled.h1`
  display: flex;
  justify-content: center;
`;
const GameListContainer = styled.div`
/* background-color: red; */
  
`;

const GameList = styled.ul`
  display: flex;
  flex-direction: row;
  justify-content: center;
`;

const GameItem = styled.li`
  /* background-color: yellow; */
  list-style: none;
  margin: 20px;
`;



function Main() {
  const [gameList, setGameList] = useState([]); // useStat 훅을 사용하게 gameList라는 상태와 setGameList라는 상태를 변경하는 함수를 정의 , 초기 값 []

  useEffect(() => {
    // gamedata.json 파일의 내용을 가져와서 gameList 상태에 설정합니다.
    setGameList(gamedata.data);
  }, []);

  // 매개변수 array , chuckSize를 받습니다. array = 묶음 대상인 배열 , chunkSize = 묶음의 크기 , 여기서는 5개.
  const chunkArray = (array, chunkSize) => {
    const chunkedArray = []; // 빈 배열 생성
    // ex) chunkSize = 5 , 현재 인덱스 = 0 , i += chunkSize === 5 , 다음 묶음의 시작 인덱스는 5 , 이후 5,10,15.... 반복문 실행
    for (let i = 0; i < array.length; i += chunkSize) {
      // 얕은 복사본을 새로운 배열 객체로 반환합니다. 원본 배열은 바뀌지 않습니다.
      // 그 후 추출한 묶음을 push 메서드를 사용하여 추가
      chunkedArray.push(array.slice(i, i + chunkSize));
    }
    return chunkedArray;
  };

  const chunkedGameList = chunkArray(gameList, 5);

  return (
    <MainContainer>
      <GameDirectory>게임 목록</GameDirectory>
      {/* 반복되는 컴포넌트를 렌더링 */}
      {/* chunk: chunkedGameList 배열의 요소, 즉 5개의 게임 객체로 이루어진 배열 , index: 현재 chunkedGameList 배열의 요소 */}
      {chunkedGameList.map((chunk, index) => (
        <GameListContainer key={index}>
          <GameList>
            {chunk.map(game => (
              <GameItem key={game.id}>
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
      ))}
    </MainContainer>
  );
}

export default Main;
