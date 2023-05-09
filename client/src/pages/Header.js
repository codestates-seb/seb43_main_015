import { useRecoilState } from "recoil";
import { HeaderContainer, Header_container,Logo,Logo_img,Gnb, Gnb_ul, Button_Container, Login_Button, SignUp_Button } from '../style/Style';
import {Link, useNavigate} from "react-router-dom";

const Header = () => {
    const navigate = useNavigate();
    const handleMain = () => {
        navigate("/");
      };
    const handleMmorpg = () => {
        navigate("/mmorpg");
      };

    const handleFps = () => {
      navigate("/fps");
    };

    const handleMusic = () => {
        navigate("/music");
      };

    const handleSports = () => {
      navigate("/sports");
    };
    const handleAction = () => {
        navigate("/action");
      };

    const handlePlash = () => {
      navigate("/plash");
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
                        <Gnb_ul onClick={handleMmorpg}>MO/MMORPG</Gnb_ul>
                        <Gnb_ul onClick={handleFps}>FPS/RTS/TPS</Gnb_ul>
                        <Gnb_ul onClick={handleMusic}>뮤직/퍼즐/보드</Gnb_ul>
                        <Gnb_ul onClick={handleSports}>스포츠/슈팅/레이싱</Gnb_ul>
                        <Gnb_ul onClick={handleAction}>액션/웹게임</Gnb_ul>
                        <Gnb_ul onClick={handlePlash}>플래시게임</Gnb_ul>
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