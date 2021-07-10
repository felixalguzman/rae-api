package com.felixalguzman.raeapi.api;

import com.felixalguzman.raeapi.Constants;
import com.felixalguzman.raeapi.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface Api {

    @GET(Constants.ANAGRAM_ENDPOINT)
    Call<AnagramResponse> getAnagrams(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.STARTS_WITH_ENDPOINT)
    Call<BaseResponse> getWordsStartingWith(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.CONTAINS_ENDPOINT)
    Call<BaseResponse> getWordsContaining(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.ENDS_WITH_ENDPOINT)
    Call<BaseResponse> getWordsEndingWith(@Header("Authorization") String authorization, @Query("w") String wordFragment);

    @GET(Constants.EXACT_ENDPOINT)
    Call<BaseResponse> getExactWord(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.FETCH_ENDPOINT)
    Call<String> getDefinitionById(@Header("Authorization") String authorization, @Query("id") String id);

    @GET(Constants.HEADER_ENDPOINT)
    Call<HeaderResponse> getHeaderById(@Header("Authorization") String authorization, @Query("id") String id);

    @GET(Constants.IDS_ENDPOINT)
    Call<IdResponse> getIdsMatchingWord(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.RANDOM_ENDPOINT)
    Call<String> getRandomWord(@Header("Authorization") String authorization);

    @GET(Constants.SEARCH_ENDPOINT)
    Call<BaseResponse> getWordSearchResults(@Header("Authorization") String authorization, @Query("w") String word);

    @GET(Constants.WOTD_ENDPOINT)
    Call<WOTDResponse> getWordOfTheDay(@Header("Authorization") String authorization);

    @GET(Constants.KEYS_ENDPOINT)
    Call<String> getSomeMatchingWords(@Header("Authorization") String authorization, @Query("q") String word);
}
