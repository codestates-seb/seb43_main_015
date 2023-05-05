import { useRecoilState } from "recoil";
import { HeaderContainer, Header_container,Logo,Logo_img,Gnb, Gnb_ul, Button_Container, Login_Button, SignUp_Button } from '../style/Style';


const Header = () => {

    return(
        <> 
            <HeaderContainer>
                <Header_container>
                    <Logo>
                        <Logo_img src='https://www.thelog.co.kr/images/common/h1_logo.png' alt="logo" />
                    </Logo>
                    <Gnb>
                        <Gnb_ul>MO/MMORPG</Gnb_ul>
                        <Gnb_ul>FPS/RTS/TPS</Gnb_ul>
                        <Gnb_ul>뮤직/퍼즐/보드</Gnb_ul>
                        <Gnb_ul>스포츠/슈팅/레이싱</Gnb_ul>
                        <Gnb_ul>액션/웹게임</Gnb_ul>
                        <Gnb_ul>플래시게임</Gnb_ul>
                    </Gnb>
                    <Button_Container>
                        <Login_Button>Log in</Login_Button>
                        <SignUp_Button>Sign Up</SignUp_Button>
                    </Button_Container>
                </Header_container>
            </HeaderContainer>
        </>
    )
}

export default Header;