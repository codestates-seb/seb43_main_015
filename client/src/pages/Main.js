import { useRecoilState } from "recoil";
import { HeaderContainer } from '../style/Style';
import styled from 'styled-components';

const Main = () => {

    const ActionPage = styled.section`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 100px;
    `

    return(
        <ActionPage>메인</ActionPage>
    )
}

export default Main;