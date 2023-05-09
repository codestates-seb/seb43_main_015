import React from 'react';
import styled from 'styled-components';
import gamedata from '../gamedata.json';

const Mmorpg = () => {
    const mmorpgGames = gamedata.data.filter(game => game.genre === "mmorpg");

    const InitPage = styled.section`
        width: 100%;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 100px;
    `;

    return (
        <InitPage>
            {mmorpgGames.map((game) => (
                <div key={game.id}>
                    <p>게임 제목: {game.title}</p>
                    <p>플랫폼: {game.platform}</p>
                    <p>장르: {game.genre}</p>
                </div>
            ))}
        </InitPage>
    );
};

export default Mmorpg;