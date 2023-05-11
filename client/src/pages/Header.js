import { useRecoilState } from "recoil";
import {Link, useNavigate} from "react-router-dom";

import { HeaderContainer, Header_container,Logo,Logo_img,Gnb, Gnb_ul, Button_Container, Login_Button, SignUp_Button } from '../style/Style';

const Header = () => {
    const navigate = useNavigate();

    const handleRoute = (event) => {
        const path = event.target.dataset.path;
        navigate(path);
    }

    const handleMain = () => {
        navigate("/");
      };

    
    const handleLogin = () => {
        navigate("/login");
      };
    
      const handleSignup = () => {
        navigate("/signup");
      };

    return(
        <> 
            <HeaderContainer>
                <Header_container>
                    <Logo>
                        <Logo_img onClick={handleMain} src='https://www.thelog.co.kr/images/common/h1_logo.png' alt="logo" />
                    </Logo>
                    <Gnb>
                        <Gnb_ul data-path="/mmorpg" onClick={handleRoute}>MO/MMORPG</Gnb_ul>
                        <Gnb_ul data-path="/fps" onClick={handleRoute}>FPS/RTS/TPS</Gnb_ul>
                        <Gnb_ul data-path="/music" onClick={handleRoute}>뮤직/퍼즐/보드</Gnb_ul>
                        <Gnb_ul data-path="/sports" onClick={handleRoute}>스포츠/슈팅/레이싱</Gnb_ul>
                        <Gnb_ul data-path="/action" onClick={handleRoute}>액션/웹게임</Gnb_ul>
                        <Gnb_ul data-path="/plash" onClick={handleRoute}>플래시게임</Gnb_ul>
                    </Gnb>
                    <Button_Container>
                        <Login_Button onClick={handleLogin}>Log in</Login_Button>
                        <SignUp_Button onClick={handleSignup}>Sign Up</SignUp_Button>
                    </Button_Container>
                </Header_container>
            </HeaderContainer>
        </>
    )
}

export default Header;