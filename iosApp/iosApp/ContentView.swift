import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewModel = ContentViewModel()

	var body: some View {
        
        List(viewModel.topHeadlines.indices) { topHeadlines in
            Text("Helloo")
        }
	}

}
