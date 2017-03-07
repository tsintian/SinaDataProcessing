package dataProcess.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Id（自增字段，全局唯一）
crawler_time(抓取时间）
crawler_time_stamp（抓取时间戳）
is_retweet（是否转发，1表示是转发 0表示原创）
user_id（本条微博的发文ID）
nick_name（本条微博的发文用户屏幕名）
tou_xiang（本条微博的发文用户的头像url）
user_type（本条微博的发文用户的类型：黄V，蓝V，会员用户，达人，普通用户）
weibo_id（本条微博的ID）
weibo_content（本条微博的内容）
zhuan（本条微博的转发数）
ping（本条微博的评论数）
zhan（本条微博的被赞数）
url（本条微博的URL）
device（本条微博的发文设备）
locate（本条微博的签到地点）
time（本条微博的发文时间）
time_stamp（本条微博的发文时间戳）
r_user_id（被转发用户ID）
r_nick_name（被转发用户屏幕名
r_user_type（被转发用户类型：黄V，蓝V，会员用户，达人，普通用户））
r_weibo_id（（被转发微博ID）
r_weibo_content（被转发微博内容）
r_zhuan（被转发微博转发数）
r_ping（被转发微博评论数）
r_zhan（被转发点赞数）
r_url（被转发微博URL）
r_device  （被转发微博的设备）
r_location（被转发微博的签到）
r_time（被转发微博的日期）
r_time_stamp（被转发微博的时间戳）
pic_content (微博配图，如果是转发型微博，则pic_content是原微博的配图）
 * 
 */


@Entity
@Table(name="Month1605")
public class M1605 implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long Id; //id filed.
	private Timestamp crawler_time;//
	private long crawler_time_stamp;
	private byte is_retweet;//（是否转发，1表示是转发 0表示原创）
	private String user_id;//（本条微博的发文ID）
	private String nick_name;//（本条微博的发文用户屏幕名）
	private String tou_xiang;//（本条微博的发文用户的头像url）
	private String user_type;//（本条微博的发文用户的类型：黄V，蓝V，会员用户，达人，普通用户）
	private String weibo_id;//（本条微博的ID）
	
	@Column(length=4096)
	private String weibo_content;//（本条微博的内容）
	
	private long zhuan;//（本条微博的转发数）
	private long ping;//（本条微博的评论数）
	private long zhan;//（本条微博的被赞数）
	private String url;//（本条微博的URL）
	@Column(length=1024)
	private String device;//（本条微博的发文设备）
	@Column(length=4096)
	private String locate;//（本条微博的签到地点）
	private Timestamp time;//（本条微博的发文时间）
	private long time_stamp;//（本条微博的发文时间戳）
	private String r_user_id;//（被转发用户ID）
	private String r_nick_name;//（被转发用户屏幕名
	private String r_user_type;//（被转发用户类型：黄V，蓝V，会员用户，达人，普通用户））
	private String r_weibo_id;//（（被转发微博ID）
	@Column(length=4096)
	private String r_weibo_content;//（被转发微博内容）
	private long r_zhuan;//（被转发微博转发数）
	private long r_ping;//（被转发微博评论数）
	private long r_zhan;//（被转发点赞数）
	private String r_url;//（被转发微博URL）
	@Column(length=1024) 
	private String r_device;//  （被转发微博的设备）
	@Column(length=4096)
	private String r_location;//（被转发微博的签到）
	private Date r_time;//（被转发微博的日期）
	private long r_time_stamp;//（被转发微博的时间戳）
	@Column(length=4096)
	private String pic_content;// (微博配图，如果是转发型微博，则pic_content是原微博的配图）
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Timestamp getCrawler_time() {
		return crawler_time;
	}
	public void setCrawler_time(Timestamp crawler_time) {
		this.crawler_time = crawler_time;
	}
	public long getCrawler_time_stamp() {
		return crawler_time_stamp;
	}
	public void setCrawler_time_stamp(long crawler_time_stamp) {
		this.crawler_time_stamp = crawler_time_stamp;
	}
	public byte getIs_retweet() {
		return is_retweet;
	}
	public void setIs_retweet(byte is_retweet) {
		this.is_retweet = is_retweet;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getTou_xiang() {
		return tou_xiang;
	}
	public void setTou_xiang(String tou_xiang) {
		this.tou_xiang = tou_xiang;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getWeibo_id() {
		return weibo_id;
	}
	public void setWeibo_id(String weibo_id) {
		this.weibo_id = weibo_id;
	}
	public String getWeibo_content() {
		return weibo_content;
	}
	public void setWeibo_content(String weibo_content) {
		this.weibo_content = weibo_content;
	}
	public long getZhuan() {
		return zhuan;
	}
	public void setZhuan(long zhuan) {
		this.zhuan = zhuan;
	}
	public long getPing() {
		return ping;
	}
	public void setPing(long ping) {
		this.ping = ping;
	}
	public long getZhan() {
		return zhan;
	}
	public void setZhan(long zhan) {
		this.zhan = zhan;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public long getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(long time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getR_user_id() {
		return r_user_id;
	}
	public void setR_user_id(String r_user_id) {
		this.r_user_id = r_user_id;
	}
	public String getR_nick_name() {
		return r_nick_name;
	}
	public void setR_nick_name(String r_nick_name) {
		this.r_nick_name = r_nick_name;
	}
	public String getR_user_type() {
		return r_user_type;
	}
	public void setR_user_type(String r_user_type) {
		this.r_user_type = r_user_type;
	}
	public String getR_weibo_id() {
		return r_weibo_id;
	}
	public void setR_weibo_id(String r_weibo_id) {
		this.r_weibo_id = r_weibo_id;
	}
	public String getR_weibo_content() {
		return r_weibo_content;
	}
	public void setR_weibo_content(String r_weibo_content) {
		this.r_weibo_content = r_weibo_content;
	}
	public long getR_zhuan() {
		return r_zhuan;
	}
	public void setR_zhuan(long r_zhuan) {
		this.r_zhuan = r_zhuan;
	}
	public long getR_ping() {
		return r_ping;
	}
	public void setR_ping(long r_ping) {
		this.r_ping = r_ping;
	}
	public long getR_zhan() {
		return r_zhan;
	}
	public void setR_zhan(long r_zhan) {
		this.r_zhan = r_zhan;
	}
	public String getR_url() {
		return r_url;
	}
	public void setR_url(String r_url) {
		this.r_url = r_url;
	}
	public String getR_device() {
		return r_device;
	}
	public void setR_device(String r_device) {
		this.r_device = r_device;
	}
	public String getR_location() {
		return r_location;
	}
	public void setR_location(String r_location) {
		this.r_location = r_location;
	}
	public Date getR_time() {
		return r_time;
	}
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
	public long getR_time_stamp() {
		return r_time_stamp;
	}
	public void setR_time_stamp(long r_time_stamp) {
		this.r_time_stamp = r_time_stamp;
	}
	public String getPic_content() {
		return pic_content;
	}
	public void setPic_content(String pic_content) {
		this.pic_content = pic_content;
	}
	
	
	
	@Override
	public String toString() {
		return "id:"+this.Id +" ;locaiton: "+this.locate+" ; crawler_time:"+this.crawler_time_stamp+" ;device: "+this.device+" ;is_tweet: "+this.is_retweet
				+" ;nick_name: "+this.nick_name+" ;pic_content: "+this.pic_content+" ;r_device: "+this.r_device+" ;r_location: "+this.r_location+" ;nick_name: "+
				this.r_nick_name+" ;r_url: "+this.r_url+" ;r_weibo_content: "+this.r_weibo_content+" ;touxiang: "+this.tou_xiang+";url: " +this.url
				+" ;weibo_content: "+this.weibo_content;
	}
	
	
	
	
}
