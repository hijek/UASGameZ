package dzaki201804016.trpl.pei.gamez

import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("Game")
    fun getGame(): Call<List<GameData>>

    @POST("Game")
    fun postGame(@Body gameData: GameData): Call<GameData>

    @GET("Sysreq")
    fun getSysreq(@Query("id") id:Int): Call<List<SysreqData>>

    @POST("Sysreq")
    fun postSysreq(@Body sysreqData: SysreqData): Call<SysreqData>


}