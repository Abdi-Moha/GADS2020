package com.abdimoha.gads2020.datasource;

import com.abdimoha.gads2020.model.SkillIQ;
import com.abdimoha.gads2020.model.SkillIQ;
import com.abdimoha.gads2020.model.TopLearner;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    //End points
    @GET("api/skilliq")
    Call<List<SkillIQ>> getTopSkill();

    @GET("api/hours")
    Call<List<TopLearner>> getTopLearners();

}
