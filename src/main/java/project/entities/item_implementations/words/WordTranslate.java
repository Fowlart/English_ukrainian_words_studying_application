package project.entities.item_implementations.words;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

public class WordTranslate {

    @Size(min = 2, message = "English word must be at least 2 characters long")
    private String engword;

    @Size(min = 2, message = "Ukraine word be at least 2 characters long")
    private String ukrword;

    @Min(value = 0, message = "Not in bound. Must be between 0 and 30")
    @Max(value = 30, message = "Not in bound. Must be between 0 and 30")
    private Integer points;

    public WordTranslate() {
        engword = "";
        ukrword = "";
        points = 0;
    }

    public WordTranslate(WordPropertie word1, WordPropertie word2, Integer points) {
        this.points = points;
        if (word1.getType() == WordsPropertyTypes.UKR) {
            ukrword = word1.getPropertieValue();
            engword = word2.getPropertieValue();
        } else if (word1.getType() == WordsPropertyTypes.ENG) {
            ukrword = word2.getPropertieValue();
            engword = word1.getPropertieValue();
        } else {
            ukrword = engword = WordsPropertyTypes.UNDEFINED.name();
        }
    }

    public String getEngword() {
        return engword.toLowerCase();
    }

    public String getUkrword() {
        return ukrword.toLowerCase();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setEngword(String engword) {
        this.engword = engword;
    }

    public void setUkrword(String ukrword) {
        this.ukrword = ukrword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordTranslate)) return false;
        WordTranslate that = (WordTranslate) o;
        return Objects.equals(engword, that.engword) &&
                Objects.equals(ukrword, that.ukrword) &&
                Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engword, ukrword, points);
    }

    @Override
    public String toString() {
        return "WordTranslate{" +
                "engword='" + engword + '\'' +
                ", ukrword='" + ukrword + '\'' +
                ", points=" + points +
                '}';
    }
}
