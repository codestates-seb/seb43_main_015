import React, { useEffect, useState } from 'react';
import axios from 'axios';

function GameList() {
  const [games, setGames] = useState([]);

  useEffect(() => {
    const fetchGames = async () => {
      try {
        const response = await axios.get('https://api.rawg.io/api/games', {
          headers: {
            Authorization: `Bearer ${process.env.REACT_APP_Game_KEY}`,
          },
        });
        setGames(response.data);
      } catch (error) {
        console.error('Error fetching games:', error);
      }
    };

    fetchGames();
  }, []);

  return (
    <div>
      <h2>Game List</h2>
      <ul>
        {games.map(game => (
          <li key={game.id}>{game.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default GameList;
