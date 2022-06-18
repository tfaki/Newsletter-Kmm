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
    let getNews: GetNews
    
    // State
    @Published var state = [Article]()
    
    init(getNews: GetNews) {
        self.getNews = getNews
        getNewsletter()
    }
        
    func getNewsletter() {
        do {
            try getNews.execute().collectCommon(
                coroutineScope: nil,
                callback: { dataState in
                    self.state = (dataState?.articles)!
                }
            )
        }catch{
        
        }
    }
}
