package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String search) {
        return storageService.getSearchables().stream()
                .filter(s -> s != null && s.getSearchTerm().contains(search))
                .map(SearchResult::fromSearchable).toList();
    }
}
