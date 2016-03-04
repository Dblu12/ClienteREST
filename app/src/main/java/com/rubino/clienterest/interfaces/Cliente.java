package com.rubino.clienterest.interfaces;

import com.rubino.clienterest.pojo.Actividad;
import com.rubino.clienterest.pojo.Grupo;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;

/**
 * Created by marco on 15/02/2016.
 */
public interface Cliente {

    @GET("restful/api/actividad/davidg")
    Call<List<Actividad>> getActividades();

    @POST("restful/api/actividad")
    Call<Actividad> createActividad(@Body Actividad actividad);

    @DELETE("restful/api/actividad/{id}")
    Call<Actividad> deleteActividad(@Path("id") String id);

    @Multipart
    @PUT("restful/api/actividad")
    Call<Actividad> updateActividad(@Part("idprofesor") String idprofesor, @Part("tipo") String tipo,
                                    @Part("fechai") String fechai,@Part("fechaf") String fechaf,
                                    @Part("lugari") String lugari,@Part("lugarf") String lugarf,
                                    @Part("descripcion") String descripcion);

    @PUT("restful/api/actividad")
    Call<Actividad> updateActividad2(@Body Actividad actividad);
}
