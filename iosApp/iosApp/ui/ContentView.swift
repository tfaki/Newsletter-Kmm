import SwiftUI
import shared

struct ContentView: View {
    
    private let getNewsModule: GetNewsModule
    private let remoteClient: RemoteClient
    
    @ObservedObject var viewModel: ContentViewModel
    
    init(remoteClient: RemoteClient) {
        self.remoteClient = remoteClient
        self.getNewsModule = GetNewsModule(
            remoteClient: self.remoteClient
        )
        self.viewModel = ContentViewModel(
            getNews: getNewsModule.getNews
        )
    }

	var body: some View {
        let list = viewModel.state
        List(list, id: \.self) { article in
            if #available(iOS 15.0, *) {
                RowItem(article: article)
                    .listRowSeparator(.hidden)
            } else {
                // Fallback on earlier versions
            }
        }
        .frame( maxWidth: .infinity)
        .listStyle(PlainListStyle())
	}

}
