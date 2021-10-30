package quotes;

public class QuoteHttp {
    String quoteText;
    String quoteAuthor;
    String quoteLink;


    public QuoteHttp(String quoteText, String quoteAuthor, String quoteLink) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.quoteLink = quoteLink;
    }


    public QuoteHttp() {

    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    public void setQuoteLink(String quoteLink) {
        this.quoteLink = quoteLink;
    }

    @Override
    public String toString() {
        return "QuoteHttp{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteLink='" + quoteLink + '\'' +
                "}";
    }

}