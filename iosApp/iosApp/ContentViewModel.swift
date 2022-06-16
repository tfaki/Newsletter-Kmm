//
//  ContentViewModel.swift
//  iosApp
//
//  Created by Talha Faki on 12.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import shared

class ContentViewModel : ObservableObject {
    @Published
    var topHeadlines = [Article]()
    
    private let topHeadlinesRepo: TopHeadlineRepository? = TopHeadlineRepository()
    
    func getTopHeadlines() {
        topHeadlinesRepo?.getTopHeadlinesData(completionHandler: { response, error in
            self.topHeadlines = (response?.articles)!
        })
    }
}
