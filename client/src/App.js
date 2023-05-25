import './App.css';
import { RecoilRoot } from 'recoil';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import styled, { ThemeProvider } from 'styled-components';
import Header from './pages/Header';
import Main from './pages/Main';
import Login from './pages/Login';
import SignUp from './pages/SignUp';
import theme from './style/theme';
import Action from './pages/Action';
import Music from './pages/Music';
import Sports from './pages/Sports';
import Plash from './pages/Plash';
import Fps from './pages/Fps';
import Mmorpg from './pages/Mmorpg';
import GameList from './pages/GameList';

function App() {
  return (
    <ThemeProvider theme={{ theme }}>
      <RecoilRoot>
        <Router>
          <Header />
          <Routes>
            <Route path="/" element={<Main />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/mmorpg" element={<Mmorpg />} />
            <Route path="/fps" element={<Fps />} />
            <Route path="/music" element={<Music />} />
            <Route path="/sports" element={<Sports />} />
            <Route path="/action" element={<Action />} />
            <Route path="/plash" element={<Plash />} />
            {/* <Route path="/gamelist" element={<GameList />} /> */}
          </Routes>
        </Router>
      </RecoilRoot>
    </ThemeProvider>
  );
}

export default App;
