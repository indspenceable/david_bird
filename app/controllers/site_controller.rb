class SiteController < ApplicationController
  def work
    @current = :work
  end
  def contact
    @current = :contact
  end
  def bio
    @current = :bio
  end
end
