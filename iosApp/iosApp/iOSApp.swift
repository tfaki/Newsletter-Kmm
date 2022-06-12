import SwiftUI
import shared

@main
struct iOSApp: App {
    
    var body: some Scene {
        WindowGroup {
            ContentView(viewModel: .init(topHeadlinesRepo: nil, topheadLines: nil))
        }
    }
}
