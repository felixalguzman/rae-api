package com.felixalguzman.raeapi.services;

import com.felixalguzman.raeapi.api.Api;
import com.felixalguzman.raeapi.config.WebService;
import com.felixalguzman.raeapi.models.*;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MainService {

    private final Api api;
    private final String accessToken;


    public MainService(WebService webService) {
        api = webService.getApiInterface();
        accessToken = webService.getBAHeader();
    }

    public BaseResponse getExactWord(String word) {
        Call<BaseResponse> call = api.getExactWord(accessToken, word);
        Response<BaseResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public AnagramResponse getAnagram(String word) {
        Call<AnagramResponse> call = api.getAnagrams(accessToken, word);
        Response<AnagramResponse> res;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public BaseResponse getWordStartingWith(String word) {
        Call<BaseResponse> call = api.getWordsStartingWith(accessToken, word);
        Response<BaseResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public BaseResponse getWordContaining(String word) {
        Call<BaseResponse> call = api.getWordsContaining(accessToken, word);
        Response<BaseResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public BaseResponse getWordEnding(String word) {
        Call<BaseResponse> call = api.getWordsEndingWith(accessToken, word);
        Response<BaseResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public String getDefinitionById(String id) {
        Call<String> call = api.getDefinitionById(accessToken, id);
        Response<String> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public HeaderResponse getHeaderResponse(String id) {
        Call<HeaderResponse> call = api.getHeaderById(accessToken, id);
        Response<HeaderResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public IdResponse getIds(String word) {
        Call<IdResponse> call = api.getIdsMatchingWord(accessToken, word);
        Response<IdResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public String getRandomWord() {
        Call<String> call = api.getRandomWord(accessToken);
        Response<String> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public BaseResponse getWordSearchResults(String word) {
        Call<BaseResponse> call = api.getWordSearchResults(accessToken, word);
        Response<BaseResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public WOTDResponse getWordOfTheDay() {
        Call<WOTDResponse> call = api.getWordOfTheDay(accessToken);
        Response<WOTDResponse> res = null;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public String getSomeMatchingWords(String word) {
        Call<String> call = api.getSomeMatchingWords(accessToken, word);
        Response<String> res;
        try {
            res = call.execute();
            return res.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }


}
