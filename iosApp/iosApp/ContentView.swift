import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    @ObservedObject private(set) var viewModel: ContentViewModel

	var body: some View {
        let list = viewModel.topHeadlines.articles
        List(list!.indices) { topHeadlines in
            Text("Helloo")
        }
	}

}
