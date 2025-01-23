package lt.techin;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class NotDependent implements NewsService {
    private List<Article> articles;
    private final String[] SWEAR_WORDS = new String[]{"rupūs miltai", "velniai rautų", "velnias", "velniais"};

    public NotDependent() {
        NewsServiceImpl newsServiceImpl = new NewsServiceImpl();
        this.articles = newsServiceImpl.getArticles();
    }


    @Override
    public List<Article> getArticles() {
        List<Article> newSafe = new ArrayList<>();
        for (Article article : articles) {
            boolean swearInHeading = false;
            for (String one : SWEAR_WORDS) {
                if (article.getHeading().toLowerCase().contains(one.toLowerCase())) {
                    swearInHeading = true;
                    break;
                }
            }
            if (swearInHeading) {
                continue;
            }

            String brief = article.getBrief();
            for (String each : SWEAR_WORDS) {
                brief = brief.replaceAll("(?i)" + each, "***");
            }

            newSafe.add(new CustomArticle(article.getHeading(), brief));
        }

        return newSafe;
    }
}
