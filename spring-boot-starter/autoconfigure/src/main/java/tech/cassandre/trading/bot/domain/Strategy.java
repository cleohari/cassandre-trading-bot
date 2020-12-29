package tech.cassandre.trading.bot.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import tech.cassandre.trading.bot.util.base.BaseDomain;
import tech.cassandre.trading.bot.util.java.EqualsBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Strategy.
 */
@Data
@Entity
@Table(name = "STRATEGIES")
public class Strategy extends BaseDomain {

    /** Technical ID. */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /** An identifier that uniquely identifies the strategy. */
    @Column(name = "STRATEGY_ID")
    private String strategyId;

    /** Strategy name. */
    @Column(name = "NAME")
    private String name;

    /** Strategy. */
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "FK_EXCHANGE_ACCOUNT_ID", updatable = false)
    private ExchangeAccount exchangeAccount;

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Strategy that = (Strategy) o;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(this.strategyId, that.strategyId)
                .isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

}