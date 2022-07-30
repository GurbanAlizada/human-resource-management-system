package com.example.service.inter;

import com.example.dtos.request.LanguageRequest;
import com.example.model.Language;

import java.util.List;

public interface LanguageServiceInter {
    public Language addLanguage(List<LanguageRequest> languageRequests);


}
