import styled from 'styled-components';

const Mmorpg = () => {
    const InitPage = styled.section`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 100px;
    `
    return(
        <InitPage>MMORPG</InitPage>
    )
}

export default Mmorpg;