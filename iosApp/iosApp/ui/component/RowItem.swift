//
//  RowItem.swift
//  iosApp
//
//  Created by Talha Faki on 18.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RowItem: View {
    var article: Article
    var body: some View {
        VStack {
            HStack {
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string: article.urlToImage ?? "")) { image in
                        image
                            .resizable()
                            .frame(width: 80, height: 100)
                            .aspectRatio(contentMode: .fit)
                            .clipShape(RoundedRectangle(cornerRadius: 6))
                            .padding(4)
                        
                    } placeholder: {
                        Image(systemName: "photo")
                            .imageScale(.large)
                            .foregroundColor(.gray)
                    }
                } else {
                    // Fallback on earlier versions
                }
                Spacer().frame(width: 25)
                VStack {
                    Text(article.author ?? "")
                        .font(.system(size: 16, weight: .heavy, design: .default))
                    Text(article.description_ ?? "")
                        .lineLimit(2)
                }
                Spacer()
            }
        }
        .frame(maxWidth: .infinity)
        .border(.gray, width: 1)
        .clipShape(RoundedRectangle(cornerRadius:8))
    }
}
