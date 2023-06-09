package com.mainproject.global.crawler;

import com.mainproject.domain.game.entity.Game;
import com.mainproject.domain.game.reposiroy.GameRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class GameInfoCrawler {
    private final GameRepository gameRepository;

    @PostConstruct // 최초 실행시 동작
    public void init() {
        updateGameRank();
    }

    @Scheduled(cron = "0 0 0 * * WED") // 매주 수요일 자정 실행
    public void updateGameRank() {
        gameRepository.deleteAll(); // 갱신하기 위해 삭제
        try {
            String url = "https://www.gamemeca.com/ranking.php";
            Document doc = Jsoup.connect(url).get();
            Elements gameList = doc.select("tr.ranking-table-rows");

            for (Element gameElement : gameList) {
                String title = gameElement.select("div.game-name a").text();
                String rank = gameElement.select("span.rank").text();
                String genre = gameElement.select("div.game-info span:nth-child(2)").text();
                String publisher = gameElement.select("div.game-info span.company a").text();
                String imageUrl = Objects.requireNonNull(gameElement.selectFirst("img.game-icon")).attr("src");

                // 게임 상세 페이지 URL 추출
                String gameDetailUrl = gameElement.select("div.game-name a").attr("href");
                String gameDetailPageUrl = "https://www.gamemeca.com" + gameDetailUrl;

                // 게임 상세 페이지로 접속하여 게임 소개 크롤링
                Document gameDetailDocument = Jsoup.connect(gameDetailPageUrl).get();
                String description = "";

                Element descriptionElement = gameDetailDocument.selectFirst("div.db-cont1-left");
                if (descriptionElement != null && !descriptionElement.text().equals("관련 정보가 없습니다")) {
                    description = descriptionElement.text();
                }

                Game game = new Game(title, rank, genre, publisher, description, imageUrl);
                gameRepository.save(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}