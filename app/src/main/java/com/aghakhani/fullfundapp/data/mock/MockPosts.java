package com.aghakhani.fullfundapp.data.mock;

import com.aghakhani.fullfundapp.data.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides hardcoded demo data for Phase 1 so the app can run
 * before the backend/API is ready.
 */
public final class MockPosts {

    private MockPosts() { /* Utility class */ }

    public static List<Post> getDefault() {
        List<Post> list = new ArrayList<>();

        list.add(new Post(
                1,
                "Fully Funded PhD - Computer Science (AI/ML)",
                "University of Toronto",
                "Canada", "CA",
                "PhD",
                "Fully Funded",
                "2026-02-10",
                "https://www.utoronto.ca/"
        ));

        list.add(new Post(
                2,
                "RA Position - Data Science / NLP",
                "MIT (Lab Position)",
                "USA", "US",
                "Research Assistant",
                "RA (Funded)",
                "2026-01-25",
                "https://www.mit.edu/"
        ));

        list.add(new Post(
                3,
                "Scholarship MSc - Electrical Engineering",
                "Technical University of Munich",
                "Germany", "DE",
                "MSc",
                "Scholarship",
                "2026-03-05",
                "https://www.tum.de/en/"
        ));

        list.add(new Post(
                4,
                "Fully Funded PhD - Software Engineering",
                "University of Cambridge",
                "UK", "UK",
                "PhD",
                "Fully Funded",
                "2026-02-20",
                "https://www.cam.ac.uk/"
        ));

        // Unknown country code => placeholder flag
        list.add(new Post(
                5,
                "Funded Position - Robotics",
                "Some University",
                "Netherlands", "NL",
                "PhD",
                "Funded",
                "2026-01-15",
                "https://www.studyinnl.org/"
        ));

        return list;
    }
}
