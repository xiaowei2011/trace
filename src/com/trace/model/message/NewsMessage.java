package com.trace.model.message;

/** 
 * @author sunweijie 
 * @since 2017年3月10日 下午8:15:35
 */
public class NewsMessage extends BaseMessage{
	
	private long ArticleCount;
	private News[] Articles;
	
	public long getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(long articleCount) {
		ArticleCount = articleCount;
	}
	public News[] getArticles() {
		return Articles;
	}
	public void setArticles(News[] articles) {
		Articles = articles;
	}
	
}
