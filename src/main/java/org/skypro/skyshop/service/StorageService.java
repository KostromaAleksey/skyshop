package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        products = new HashMap<>();
        articles = new HashMap<>();
        initMaps();
    }

    private void initMaps() {
        Product product1 = new SimpleProduct(UUID.randomUUID(), "apple", 5);
        Product product2 = new SimpleProduct(UUID.randomUUID(), "apple", 6);
        Product product3 = new FixPriceProduct(UUID.randomUUID(), "brad");
        Product product4 = new DiscountedProduct(UUID.randomUUID(), "egg", 10, 5);
        Product product5 = new DiscountedProduct(UUID.randomUUID(), "egg", 11, 6);
        Product product6 = new DiscountedProduct(UUID.randomUUID(), "oil", 111, 40);
        Product product7 = new FixPriceProduct(UUID.randomUUID(), "paper");
        Product product8 = new SimpleProduct(UUID.randomUUID(), "cup", 250);
        Product product9 = new DiscountedProduct(UUID.randomUUID(), "egg", 10, 5);

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
        products.put(product5.getId(), product5);
        products.put(product6.getId(), product6);
        products.put(product7.getId(), product7);
        products.put(product8.getId(), product8);
        products.put(product9.getId(), product9);

        Article article1 = new Article(UUID.randomUUID(), "article1", "article1Text");
        Article article2 = new Article(UUID.randomUUID(), "article2", "article2Text");
        Article article3 = new Article(UUID.randomUUID(), "article3", "article3Text");

        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
        articles.put(article3.getId(), article3);
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public Collection<Article> getArticles() {
        return articles.values();
    }

    public Collection<Searchable> getSearchables() {
        List<Searchable> searchables = new ArrayList<>(products.values());
        searchables.addAll(articles.values());
        return searchables;
    }
}
