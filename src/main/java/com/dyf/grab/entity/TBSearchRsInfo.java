package com.dyf.grab.entity;

public class TBSearchRsInfo {
    String nid ;//产品id
    String category ;//产品目录
    String pid ;//上级id
    String raw_title ;//产品标题
    String pic_url ;//图片地址
    String detail_url ;//详情地址
    String view_price ;//销售价格
    String view_fee;//运费
    String item_loc ;//发货地
    String user_id ;//用户id
    String nick ;//店铺名称
    String isTmall ;//是否天猫店
    String view_sales ;//是否天猫店
    
    
	public String getView_sales() {
		return view_sales;
	}
	public void setView_sales(String view_sales) {
		this.view_sales = view_sales;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRaw_title() {
		return raw_title;
	}
	public void setRaw_title(String raw_title) {
		this.raw_title = raw_title;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public String getView_price() {
		return view_price;
	}
	public void setView_price(String view_price) {
		this.view_price = view_price;
	}
	public String getView_fee() {
		return view_fee;
	}
	public void setView_fee(String view_fee) {
		this.view_fee = view_fee;
	}
	public String getItem_loc() {
		return item_loc;
	}
	public void setItem_loc(String item_loc) {
		this.item_loc = item_loc;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIsTmall() {
		return isTmall;
	}
	public void setIsTmall(String isTmall) {
		this.isTmall = isTmall;
	}
	@Override
	public String toString() {
		return "TBSearchRsInfo [nid=" + nid + ", category=" + category + ", pid=" + pid + ", raw_title=" + raw_title
				+ ", pic_url=" + pic_url + ", detail_url=" + detail_url + ", view_price=" + view_price + ", view_fee="
				+ view_fee + ", item_loc=" + item_loc + ", user_id=" + user_id + ", nick=" + nick + ", isTmall="
				+ isTmall + ", view_sales=" + view_sales + "]";
	}


	
    
}
