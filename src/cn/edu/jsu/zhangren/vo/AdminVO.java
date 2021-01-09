package cn.edu.jsu.zhangren.vo;
/**
 * 定义账户密码实体类
 * @author 10073
 *
 */
public class AdminVO {
	private String name;           //姓名
	private String password;      //密码
	@Override
	public String toString() {
		return "AdminVO [name=" + name + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		AdminVO other = (AdminVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	void setName(String name) {
	    this.name=name;
	}
	void setPassword(String password) {
	    this.password=password;
	} 
	String getName() {
	    return this.name;
	}
	String getPassword() {
	    return this.password;
	}

}

