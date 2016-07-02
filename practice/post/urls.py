from django.conf.urls import url, include
from .views import PostView

urlpatterns = [
    url(r'^posts/(?P<institute>[0-9]+)', PostView.as_view(), name='posts'),

]
