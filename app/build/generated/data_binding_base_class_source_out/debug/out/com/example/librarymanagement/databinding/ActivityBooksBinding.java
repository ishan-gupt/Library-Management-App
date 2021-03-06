// Generated by view binder compiler. Do not edit!
package com.example.librarymanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.example.librarymanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBooksBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout author;

  @NonNull
  public final LinearLayout code;

  @NonNull
  public final LinearLayout count;

  @NonNull
  public final LinearLayout dept;

  @NonNull
  public final ImageView imageBooks;

  @NonNull
  public final TextView libraryBooksAuthor;

  @NonNull
  public final TextView libraryBooksCode;

  @NonNull
  public final TextView libraryBooksCount;

  @NonNull
  public final TextView libraryBooksDept;

  @NonNull
  public final TextView libraryBooksName;

  @NonNull
  public final TextView libraryBooksPrice;

  @NonNull
  public final TextView libraryBooksSem;

  @NonNull
  public final LinearLayout name;

  @NonNull
  public final LinearLayout price;

  @NonNull
  public final LinearLayout sem;

  @NonNull
  public final Toolbar toolbar1;

  private ActivityBooksBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout author,
      @NonNull LinearLayout code, @NonNull LinearLayout count, @NonNull LinearLayout dept,
      @NonNull ImageView imageBooks, @NonNull TextView libraryBooksAuthor,
      @NonNull TextView libraryBooksCode, @NonNull TextView libraryBooksCount,
      @NonNull TextView libraryBooksDept, @NonNull TextView libraryBooksName,
      @NonNull TextView libraryBooksPrice, @NonNull TextView libraryBooksSem,
      @NonNull LinearLayout name, @NonNull LinearLayout price, @NonNull LinearLayout sem,
      @NonNull Toolbar toolbar1) {
    this.rootView = rootView;
    this.author = author;
    this.code = code;
    this.count = count;
    this.dept = dept;
    this.imageBooks = imageBooks;
    this.libraryBooksAuthor = libraryBooksAuthor;
    this.libraryBooksCode = libraryBooksCode;
    this.libraryBooksCount = libraryBooksCount;
    this.libraryBooksDept = libraryBooksDept;
    this.libraryBooksName = libraryBooksName;
    this.libraryBooksPrice = libraryBooksPrice;
    this.libraryBooksSem = libraryBooksSem;
    this.name = name;
    this.price = price;
    this.sem = sem;
    this.toolbar1 = toolbar1;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBooksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_books, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBooksBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.author;
      LinearLayout author = rootView.findViewById(id);
      if (author == null) {
        break missingId;
      }

      id = R.id.code;
      LinearLayout code = rootView.findViewById(id);
      if (code == null) {
        break missingId;
      }

      id = R.id.count;
      LinearLayout count = rootView.findViewById(id);
      if (count == null) {
        break missingId;
      }

      id = R.id.dept;
      LinearLayout dept = rootView.findViewById(id);
      if (dept == null) {
        break missingId;
      }

      id = R.id.image_books;
      ImageView imageBooks = rootView.findViewById(id);
      if (imageBooks == null) {
        break missingId;
      }

      id = R.id.library_books_author;
      TextView libraryBooksAuthor = rootView.findViewById(id);
      if (libraryBooksAuthor == null) {
        break missingId;
      }

      id = R.id.library_books_code;
      TextView libraryBooksCode = rootView.findViewById(id);
      if (libraryBooksCode == null) {
        break missingId;
      }

      id = R.id.library_books_count;
      TextView libraryBooksCount = rootView.findViewById(id);
      if (libraryBooksCount == null) {
        break missingId;
      }

      id = R.id.library_books_dept;
      TextView libraryBooksDept = rootView.findViewById(id);
      if (libraryBooksDept == null) {
        break missingId;
      }

      id = R.id.library_books_name;
      TextView libraryBooksName = rootView.findViewById(id);
      if (libraryBooksName == null) {
        break missingId;
      }

      id = R.id.library_books_price;
      TextView libraryBooksPrice = rootView.findViewById(id);
      if (libraryBooksPrice == null) {
        break missingId;
      }

      id = R.id.library_books_sem;
      TextView libraryBooksSem = rootView.findViewById(id);
      if (libraryBooksSem == null) {
        break missingId;
      }

      id = R.id.name;
      LinearLayout name = rootView.findViewById(id);
      if (name == null) {
        break missingId;
      }

      id = R.id.price;
      LinearLayout price = rootView.findViewById(id);
      if (price == null) {
        break missingId;
      }

      id = R.id.sem;
      LinearLayout sem = rootView.findViewById(id);
      if (sem == null) {
        break missingId;
      }

      id = R.id.toolbar1;
      Toolbar toolbar1 = rootView.findViewById(id);
      if (toolbar1 == null) {
        break missingId;
      }

      return new ActivityBooksBinding((RelativeLayout) rootView, author, code, count, dept,
          imageBooks, libraryBooksAuthor, libraryBooksCode, libraryBooksCount, libraryBooksDept,
          libraryBooksName, libraryBooksPrice, libraryBooksSem, name, price, sem, toolbar1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
