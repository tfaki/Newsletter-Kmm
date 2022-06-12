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
    var topHeadlines: TopHeadlinesResponse
    
    private let topHeadlinesRepo: TopHeadlineRepository
    
    init(topHeadlinesRepo: TopHeadlineRepository?, topheadLines: TopHeadlinesResponse?) {
        self.topHeadlinesRepo = topHeadlinesRepo!
        self.topHeadlines = topheadLines!
    }
    
    func getTopHeadlines() {
        topHeadlinesRepo.getTopHeadlinesData(completionHandler: { response, error in
            self.topHeadlines = response!
        })
    }
}
