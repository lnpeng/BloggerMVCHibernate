package microblogger.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="blog")
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

	@Column(name="message")
    private String message;

	@Column(name="created_at")
    private Date createTime;

    private Blog() {}

    public Blog(String message, Date time) {
        this(null, message, time);
    }

    public Blog(Long id, String message, Date time) {
        this.id = id;
        this.message = message;
        this.createTime = time;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "createTime");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "createTime");
    }
}
