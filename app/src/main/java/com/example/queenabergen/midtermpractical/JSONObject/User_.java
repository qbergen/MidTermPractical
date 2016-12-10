package com.example.queenabergen.midtermpractical.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by queenabergen on 12/10/16.
 */

public class User_ {

    @SerializedName("private")
    @Expose
    private Integer _private;

    /**
     *
     * @return
     * The _private
     */
    public Integer getPrivate() {
        return _private;
    }

    /**
     *
     * @param _private
     * The private
     */
    public void setPrivate(Integer _private) {
        this._private = _private;
    }
}
