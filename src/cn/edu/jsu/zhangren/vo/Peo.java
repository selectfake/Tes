package cn.edu.jsu.zhangren.vo;
/**
 * 定义姓名，性别，电话，作品实体类
 */
import cn.edu.jsu.zhangren.view.main;

public class Peo {
	private String xm;
	private String xb;
	private String dh;
	private String zp;
	public Peo() {};
	public Peo(String xm, String xb, String dh, String zp) {
		super();
		this.xm = xm;
		this.xb = xb;
		this.dh = dh;
		this.zp = zp;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getZp() {
		return zp;
	}
	public void setZp(String zp) {
		this.zp = zp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dh == null) ? 0 : dh.hashCode());
		result = prime * result + ((xb == null) ? 0 : xb.hashCode());
		result = prime * result + ((xm == null) ? 0 : xm.hashCode());
		result = prime * result + ((zp == null) ? 0 : zp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peo other = (Peo) obj;
		if (dh == null) {
			if (other.dh != null)
				return false;
		} else if (!dh.equals(other.dh))
			return false;
		if (xb == null) {
			if (other.xb != null)
				return false;
		} else if (!xb.equals(other.xb))
			return false;
		if (xm == null) {
			if (other.xm != null)
				return false;
		} else if (!xm.equals(other.xm))
			return false;
		if (zp == null) {
			if (other.zp != null)
				return false;
		} else if (!zp.equals(other.zp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return xm +"\t" +xb+"\t"+ dh+"\t"  + zp ;
	}
	
}
