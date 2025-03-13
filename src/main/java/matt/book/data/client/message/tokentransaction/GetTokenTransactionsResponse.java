package matt.book.data.client.message.tokentransaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.tokentransaction.TokenTransaction;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTokenTransactionsResponse implements Serializable {
    private List<TokenTransaction> tokenTransactionList;
}
